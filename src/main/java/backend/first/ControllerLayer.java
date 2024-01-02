package backend.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RestController//Spring will understand that here all the API's are written
@RequestMapping("/banking")
public class ControllerLayer {
    @Autowired
    private ServiceLayer serviceLayerObj;//created object for 1st time, getting it with help of AutoWired annonations
    List<Employee> listOfEmployees = new ArrayList<>();
    @PostMapping("/addEmployee")
    public ResponseEntity<String> addToDb(@RequestBody Employee employee){//you will get the result from service layer, just add status code and return to frontend
       String res =  serviceLayerObj.addEmployee(employee);
       return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/getEmployee/{userId}")
    public  ResponseEntity<Employee> getEmployeeFromDb(@PathVariable("userId")String userId){
        Employee employee = serviceLayerObj.getEmployee(userId);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
//instead of req.param, path variable could also be done
    /*
    public User getUser(@PathVariable("userId")Integer userId){
        User user = userDb.get(userId);
        return user;}
     */
    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getEmployeesFromDb(){
        listOfEmployees = serviceLayerObj.getAllEmployees();
        return new ResponseEntity<>(listOfEmployees,HttpStatus.ACCEPTED);
    }
}
