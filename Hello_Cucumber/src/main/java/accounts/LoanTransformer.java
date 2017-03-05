package accounts;

import cucumber.api.Transformer;

public class LoanTransformer extends Transformer<Loan> {

        @Override
        public Loan transform(String value) {
        	Loan loan = new Loan();
        	loan.setAmount(loan);
            return loan;
        }
   

}
