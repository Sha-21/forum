import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticationService } from 'src/app/auth/services/authentication.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

  constructor(private authenticationService: AuthenticationService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // add authorization header with jwt token if available
        let user = this.authenticationService.currentUserValue;
        if (user && user.accessToken && user.tokenType) {
            request = request.clone({
                setHeaders: {
                    Authorization: `${user.tokenType} ${user.accessToken}`
                }
            });
        }

        return next.handle(request);
    }
}
