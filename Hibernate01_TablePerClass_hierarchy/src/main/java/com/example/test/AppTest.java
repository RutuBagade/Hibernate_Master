package com.example.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entity.ChequePayment;
import com.example.entity.CreditCardPayment;
import com.example.utils.HibernateUtil;
/* This design provides single table for all model classes. It will considers all classes variables as
column names and takes one extra column “Discriminator” which provides information like
“Row related to which model class”..
We can use the Hibernate Table per Class strategy, if we want to store the data of all classes hierarchy into a single database table. 
For this strategy we can store all classes data in a single table.*/
public class AppTest {

	public static void main(String[] args) {
		Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	CreditCardPayment creditCardPayment=new CreditCardPayment();
            creditCardPayment.setPaymentId(1003);
            creditCardPayment.setAmount(30000.00);
            creditCardPayment.setCardType("ICICI");
            creditCardPayment.setCardNumer(526253252);
            
            ChequePayment chequePayment=new ChequePayment();
            chequePayment.setAmount(2000.00);
            chequePayment.setPaymentId(1004);
            chequePayment.setChequeType("ORDER");
            chequePayment.setChequeNumber(0005265232);
            
            transaction=session.beginTransaction();
            session.save(creditCardPayment);
            session.save(chequePayment);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        

	}

}
