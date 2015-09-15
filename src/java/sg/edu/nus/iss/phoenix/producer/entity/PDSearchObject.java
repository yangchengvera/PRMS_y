package sg.edu.nus.iss.phoenix.producer.entity;

import java.sql.Date;
import sg.edu.nus.iss.phoenix.radioprogram.entity.*;

public class PDSearchObject {
	  private String name;
	    private String address;
            private Date datejoin;
		public PDSearchObject() {
			super();
		}
		public PDSearchObject(String name, String description) {
			super();
			this.name = name;
			this.address = description;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
                public void setjoindate(Date datejoin){
                        this.datejoin = datejoin;
                }
}
