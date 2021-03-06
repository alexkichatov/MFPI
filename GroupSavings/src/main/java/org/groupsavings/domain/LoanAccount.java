package org.groupsavings.domain;

import java.io.Serializable;

/**
 * Created by shashank on 19/4/14.
 */
public class LoanAccount implements Serializable {

    public String Id;
    public String MemberId;
    public String GroupId;
    public String GroupMeetingId;
    public float Principal;
    public float InterestRate;
    public int PeriodInMonths;
    public float EMI;
    public float Outstanding;
    public String Reason;
    public String Guarantor;
    public boolean IsEmergency;
    public String StartDate;
    public String EndDate;
    public String CreatedDate;
    public String CreatedBy;
    public boolean Active;

    // Used in UI
    public Member Member;

    public float getEMI()
    {
        float simpleInterest = (Principal * InterestRate * PeriodInMonths / 1200);
        float total = Principal + Math.round(simpleInterest);
        float quotient = (int) total / PeriodInMonths;
        float remainder = (int) total % PeriodInMonths;
        if(remainder > 0) quotient ++;

        EMI = quotient;
        return EMI;
    }

    public float getInitialOutstanding()
    {
        float simpleInterest = (Principal * InterestRate * PeriodInMonths / 1200);
        return Principal +  Math.round(simpleInterest);
    }

}
