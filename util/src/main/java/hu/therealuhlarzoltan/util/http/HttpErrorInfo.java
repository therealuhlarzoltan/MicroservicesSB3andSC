package hu.therealuhlarzoltan.util.http;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor(force = true)
public class HttpErrorInfo {
    @Getter
    private final ZonedDateTime timestamp;
    @Getter
    private final String path;
    @Getter
    private final HttpStatus httpStatus;
    @Getter
    private final String message;

    public HttpErrorInfo(HttpStatus httpStatus, String path, String message) {
        timestamp = ZonedDateTime.now();
        this.httpStatus = httpStatus;
        this.path = path;
        this.message = message;
    }
}
