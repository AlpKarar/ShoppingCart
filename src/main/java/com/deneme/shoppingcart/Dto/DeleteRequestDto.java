package com.deneme.shoppingcart.Dto;

public class DeleteRequestDto {
    private int pid;

    public DeleteRequestDto() {};

    public DeleteRequestDto(int pid) {
        this.pid = pid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
