package com.asusoftware.mytransporter.exception.company;

/**
 * my-transporter Created by Antonio on 12/21/2020
 */
public class CompanyNotFoundException  extends CompanyException{
    public CompanyNotFoundException() {
        super("Company not found");
    }
}
