package nextstep.auth;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class AuthE2ETest {
    @Test
    @DisplayName("존재하는 유저는 엑세스 토큰을 발급 받을 수 있다.")
    void test1() {
        TokenResponse tokenResponse = AuthTestUtil.tokenLoginForReservationExistUser();
        assertThat(tokenResponse.getAccessToken()).isNotNull();
    }

    @Test
    @DisplayName("존재하지 않는 유저는 엑세스 토큰을 받을 수 없다.")
    void test2() {
        TokenRequest tokenRequest = AuthTestUtil.getNotExistUserTokenRequest();
        AuthTestUtil.createTokenAndGetValidatableResponse(tokenRequest)
                .statusCode(HttpStatus.UNAUTHORIZED.value());
    }

    @DisplayName("token에는 username이 반드시 포함되어야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void test3(String username) {
        TokenRequest tokenRequest = new TokenRequest(username, "");
        AuthTestUtil.createTokenAndGetValidatableResponse(tokenRequest)
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @DisplayName("token에는 password가 반드시 포함되어야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void test4(String password) {
        TokenRequest tokenRequest = new TokenRequest("username", password);
        AuthTestUtil.createTokenAndGetValidatableResponse(tokenRequest)
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }
}
