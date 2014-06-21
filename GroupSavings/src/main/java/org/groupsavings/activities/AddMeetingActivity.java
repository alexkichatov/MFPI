package org.groupsavings.activities;

import android.app.Activity;

public class AddMeetingActivity extends Activity {

    /*String groupId;
    Group group;
    DatabaseHandler dbHandler;
    ArrayList<Member> groupMembers;

    //Meeting Transactions and its adapter
    ArrayList<MeetingTransaction> transactions;
    MeetingTransactionsAdapter transactionsAdapter;

    //Loan Accounts and its adapter
    ArrayList<LoanAccount> loanAccounts;
    MeetingLoanAdapter loansAdapter;
    ListView lv_loanAccounts;

//  session management declarations start
    UserSessionManager session;
    private Handler handler = new Handler();
//  session management declarations end

    public final int REQUEST_GET_NEW_LOANACCOUNT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));

        try{
            super.onCreate(savedInstanceState);

            Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));

            setContentView(R.layout.activity_add_meeting);

            //user session management starts
            session = new UserSessionManager(getApplicationContext());

            if(!session.isUserLoggedIn()) {
                //redirect to login activity
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }

            HashMap<String, String> user = session.getUserDetails();
            String name = user.get(UserSessionManager.KEY_NAME);
            Toast.makeText(getApplicationContext(), "User Login Status: " + session.isUserLoggedIn() + " Name: " + name, Toast.LENGTH_LONG).show();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(i);
                }
            }, 1800000);// session timeout of 30 minutes
            //user session management ends


            groupId = getIntent().getIntExtra(GroupLandingActivity.INTENT_EXTRA_GROUP, 0);
            dbHandler = new DatabaseHandler(getApplicationContext());
            group = dbHandler.getGroup(groupId);
            groupMembers = dbHandler.getAllMembers(groupId);
            transactions = populateMeetingTransactions(group, groupMembers);

            ListView lv_transactions = (ListView) findViewById(R.id.listview_meeting_transactions);
            transactionsAdapter = new MeetingTransactionsAdapter(this, android.R.layout.simple_list_item_1, transactions,false);
            lv_transactions.setAdapter(transactionsAdapter);

            loanAccounts = new ArrayList<LoanAccount>();
            lv_loanAccounts = (ListView) findViewById(R.id.lv_meeting_loans);
            loansAdapter = new MeetingLoanAdapter(this, android.R.layout.simple_list_item_1, loanAccounts);
            lv_loanAccounts.setAdapter(loansAdapter);

        }
        catch (Exception ex)
        {
            Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private ArrayList<MeetingTransaction> populateMeetingTransactions(Group group, ArrayList<Member> members) {
        ArrayList<MeetingTransaction> transactions = new ArrayList<MeetingTransaction>();

        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            MeetingTransaction transaction = new MeetingTransaction(groupId, member);
            transaction.SavingTransaction.groupCompulsorySavings = group.RecurringSavings;

            LoanAccount la = dbHandler.getMemberActiveLoanAccount(member.UID);
            if (la != null)
            {
                transaction.LoanTransaction.GroupMemberLoanAccountId = la.Id;
                transaction.LoanTransaction.EMI = la.EMI;
                if(transaction.LoanTransaction.EMI > la.OutStanding)
                    transaction.LoanTransaction.Repayment = la.OutStanding;
                else
                    transaction.LoanTransaction.Repayment = la.EMI;
                transaction.LoanTransaction.setOutstandingDue(la.OutStanding);
            }
            transactions.add(transaction);
        }

        return transactions;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_meeting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.button_save_meeting_details:
                dbHandler.saveMeetingDetails(groupId, transactions, loanAccounts);
                Toast.makeText(this, "Meeting Details Saved", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.bt_add_new_loan:
                Intent intent = new Intent(this,NewLoanActivity.class);
                int [] alreadyLoaned = new int[loanAccounts.size()];
                for(int i = 0; i<loanAccounts.size(); i++)
                {
                    alreadyLoaned[i]=loanAccounts.get(i).memberId;
                }
                intent.putExtra(GroupLandingActivity.INTENT_EXTRA_GROUP, groupId);
                intent.putExtra(GroupLandingActivity.INTENT_EXTRA_ALREADY_LOANED_MEMBER_IDS,alreadyLoaned);
                intent.putExtra(GroupLandingActivity.INTENT_EXTRA_ALREADY_LOANED_COUNT,loanAccounts.size());
                startActivityForResult(intent, REQUEST_GET_NEW_LOANACCOUNT);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == REQUEST_GET_NEW_LOANACCOUNT) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.
                try {
                    // Get the new loan object fetched via JSON
                    JSONObject jo = new JSONObject(data.getStringExtra(NewLoanActivity.INTENT_EXTRA_RETURN_LOAN_ACCOUNT_JSON));
                    LoanAccount la = SyncHelper.getLoanAccFromJson(jo);
                    // Put Member object in place of member id
                    for(Member member : groupMembers)
                    {
                        if(member.UID == la.memberId)
                        {
                            la.GroupMember = member;
                            la.memberId = member.UID;
                            break;
                        }
                    }
                    loanAccounts.add(la);
                    RefreshView();
                } catch (JSONException e) {
                    Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public void RefreshView()
    {
        loansAdapter = new MeetingLoanAdapter(this, android.R.layout.simple_list_item_1, loanAccounts);;
        lv_loanAccounts.setAdapter(loansAdapter);
    }
    */
}
