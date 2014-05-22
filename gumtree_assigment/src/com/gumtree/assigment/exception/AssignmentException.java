package com.gumtree.assigment.exception;

/**
 * Created by Dilyan B. on 14-5-22.
 */
public class AssignmentException extends Exception {

    public AssignmentException(String title){
        super(title);
    }

    public AssignmentException(Exception e) {
        super(e);
    }
}
