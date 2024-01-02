package backend.first;
public class Employee {
    private String userId;
    private  double SalaryPerHour;
    private  String workingHrsPerDay;
    private String workingDaysPerWeak;
    private String payPeriod;
    private boolean overTime;
    private boolean betweenTwoFive;
    private boolean nationalHolidays;
    String type;

    public Employee(String userId, String workingHrsPerDay, String workingDaysPerWeak, String payPeriod, boolean overTime, String type, boolean betweenTwoFive, boolean nationalHolidays) {
        this.userId = userId;
        this.SalaryPerHour = 100;
        this.workingHrsPerDay = workingHrsPerDay;
        this.workingDaysPerWeak = workingDaysPerWeak;
        this.payPeriod = payPeriod;
        this.overTime = overTime;
        this.type = type;
        this.betweenTwoFive = betweenTwoFive;
        this.nationalHolidays = nationalHolidays;
    }
    public Employee(){ //This is also mandatory

    }
    public String getUserId() {
        return userId;
    }

    public boolean getOverTime() {
        return overTime;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public String getWorkingDaysPerWeak() {
        return workingDaysPerWeak;
    }

    public String getWorkingHrsPerDay() {
        return workingHrsPerDay;
    }

    public double getSalary() {
        if(overTime &&  (Integer.valueOf(this.workingDaysPerWeak) * Integer.valueOf(this.workingHrsPerDay)) == 50) {
            //
            double newSalary = SalaryPerHour + (SalaryPerHour * 0.2);
            return newSalary * Integer.valueOf(this.workingDaysPerWeak) * Integer.valueOf(this.workingHrsPerDay);
        }else if( overTime && (Integer.valueOf(this.workingDaysPerWeak) * Integer.valueOf(this.workingHrsPerDay)) > 50){
            double newSalary = SalaryPerHour + (SalaryPerHour * 0.15);
            return newSalary * Integer.valueOf(this.workingDaysPerWeak) * Integer.valueOf(this.workingHrsPerDay);
        }else if(overTime && betweenTwoFive){
            double newSalary = SalaryPerHour + (SalaryPerHour * 0.25);
            return newSalary * Integer.valueOf(this.workingDaysPerWeak) * Integer.valueOf(this.workingHrsPerDay);
        }
        else if(overTime && nationalHolidays){
            double newSalary = SalaryPerHour + (SalaryPerHour * 0.30);
            return newSalary * Integer.valueOf(this.workingDaysPerWeak) * Integer.valueOf(this.workingHrsPerDay);
        }
        return SalaryPerHour * Integer.valueOf(this.workingDaysPerWeak) * Integer.valueOf(this.workingHrsPerDay);
    }
}
