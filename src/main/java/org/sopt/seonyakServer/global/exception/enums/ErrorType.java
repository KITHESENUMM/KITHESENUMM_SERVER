package org.sopt.seonyakServer.global.exception.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorType {
    /**
     * 400 BAD REQUEST
     */

    // 표준 오류
    REQUEST_VALIDATION_ERROR(HttpStatus.BAD_REQUEST,"40001", "잘못된 요청입니다."),
    INVALID_TYPE_ERROR(HttpStatus.BAD_REQUEST,"40002","잘못된 타입이 입력되었습니다."),
    INVALID_MISSING_HEADER_ERROR(HttpStatus.BAD_REQUEST,"40003", "요청에 필요한 헤더값이 존재하지 않습니다."),
    INVALID_HTTP_REQUEST_ERROR(HttpStatus.BAD_REQUEST, "40004", "요청 형식이 허용된 형식과 다릅니다."),
    INVALID_HTTP_METHOD_ERROR(HttpStatus.BAD_REQUEST, "40005", "지원되지 않는 HTTP method 요청입니다."),
    INVALID_TOKEN_HEADER_ERROR(HttpStatus.BAD_REQUEST, "40006", "토큰 헤더값의 형식이 잘못되었습니다."),
    INVALID_CODE_HEADER_ERROR(HttpStatus.BAD_REQUEST, "40007", "code 헤더값의 형식이 잘못되었습니다."),

    // S3 관련 오류
    IMAGE_EXTENSION_ERROR(HttpStatus.BAD_REQUEST, "40008", "이미지 확장자는 jpg, png, webp만 가능합니다."),
    IMAGE_SIZE_ERROR(HttpStatus.BAD_REQUEST, "40009", "이미지 사이즈는 5MB를 넘을 수 없습니다."),

    // 인증 관련 오류
    EMPTY_PRINCIPLE_ERROR(HttpStatus.BAD_REQUEST, "40010", "Principle 객체가 없습니다. (null)"),

    /**
     * 401 UNAUTHORIZED
     */
    INVALID_JWT_TOKEN(HttpStatus.UNAUTHORIZED, "40101", "유효하지 않는 JWT 토큰입니다."),
    EXPIRED_JWT_TOKEN(HttpStatus.UNAUTHORIZED, "40102", "만료된 JWT 토큰입니다."),
    UNSUPPORTED_JWT_TOKEN(HttpStatus.UNAUTHORIZED, "40103", "지원하지 않는 JWT 토큰입니다."),
    EMPTY_JWT_TOKEN(HttpStatus.UNAUTHORIZED, "40104", "JWT 토큰이 존재하지 않습니다."),
    INVALID_JWT_SIGNATURE(HttpStatus.UNAUTHORIZED, "40105", "잘못된 JWT 서명입니다."),
    UNKNOWN_JWT_ERROR(HttpStatus.UNAUTHORIZED, "40106", "알 수 없는 JWT 토큰 오류가 발생했습니다."),

    INVALID_SOCIAL_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED, "40107", "유효하지 않은 소셜 엑세스 토큰입니다."),
    INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "40108", "유효하지 않은 리프레시 토큰입니다, 다시 로그인을 해주세요."),

    /**
     * 404 NOT FOUND
     */
    NOT_FOUND_MEMBER_ERROR(HttpStatus.NOT_FOUND, "40401", "존재하지 않는 회원입니다."),
    NOT_FOUND_REFRESH_TOKEN_ERROR(HttpStatus.NOT_FOUND, "40402", "존재하지 않는 리프레시 토큰입니다."),

    /**
     * 409 CONFLICT
     */
    NICKNAME_DUP_ERROR(HttpStatus.CONFLICT, "40901", "중복된 회원 닉네임입니다."),


    /**
     * 500 INTERNAL SERVER ERROR
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "50001", "알 수 없는 서버 에러가 발생했습니다."),
    GET_UPLOAD_PRESIGNED_URL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "50002", "업로드를 위한 Presigned URL 획득에 실패했습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
