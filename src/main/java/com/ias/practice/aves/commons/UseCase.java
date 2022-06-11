package com.ias.practice.aves.commons;

public interface UseCase <Input, Output>{
    Output execute(Input input);
}
