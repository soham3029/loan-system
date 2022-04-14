package com.example.relaxpay.request;

import com.example.relaxpay.dto.FetchDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FetchAccountRequest {
    private List<FetchDTO> dtos;
}
