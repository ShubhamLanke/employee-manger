import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
    providedIn: 'root'
    })
    export class EmployeeService {
        private apiServerUrl = '';

        constructor(private http: HttpClient) { }

        public getEmployees (): Observable<Employee[]> {
            return this.http.get<Employee[]>(`${this.apiServerUrl}/employee/all`);
        }

        public getEmployee (employeeId : Employee): Observable<Employee> {
            return this.http.get<Employee>(`${this.apiServerUrl}/employee/${employeeId}`);
        }

        public addEmployees (employee : Employee): Observable<Employee> {
            return this.http.post<Employee>(`${this.apiServerUrl}/employee/all`, employee);
        }

        
    }