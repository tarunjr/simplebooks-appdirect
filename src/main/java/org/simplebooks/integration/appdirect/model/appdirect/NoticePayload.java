package org.simplebooks.integration.appdirect.model.appdirect;

import org.simplebooks.integration.appdirect.model.appdirect.Account;
import org.simplebooks.integration.appdirect.model.appdirect.Notice;

/*
"payload": {
      "account": {
        "accountIdentifier": "a3f72246-5377-4d92-8bdc-b1b6b450c55c",
        "status": "ACTIVE"
      },
      "notice": { "type": "UPCOMING_INVOICE" }
    }
*/

public class NoticePayload {
    private Account account;
    public Account getAccount() {
      return account;
    }
    public void setAccount(Account account) {
      this.account = account;
    }

    private Notice notice;
    public Notice getNotice() {
      return notice;
    }
    public void setNotice(Notice notice) {
      this.notice = notice;
    }
}
