package com.example.backend.requests;

import com.example.backend.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Request {

    private Employee employee;

}
