package org.groupsavings.domain;

import java.io.Serializable;

/**
 * Created by rohan on 15/6/14.
 */
public class MeetingDetails implements Serializable{

    public String MeetingId;
    public String MemberId;
    public boolean IsAbsent;
    public float Fine;

    public Member member;
}
