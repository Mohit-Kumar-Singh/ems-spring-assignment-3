package co.in.vwits.services.imp;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.in.vwits.dao.EmpDao;
import co.in.vwits.dao.imp.EmpDaoJpaImpl;
import co.in.vwits.model.Emp;
import co.in.vwits.services.EmpService;


@Service
@Transactional
public class EmpServiceImp implements EmpService{
	
	@Autowired
	public EmpDaoJpaImpl emp;
	
	public List<Emp> findAll() {
		
		return emp.findAll();
		
	}

	public void save(Emp e) {
		emp.save(e);
	}

	public Optional<Emp> findByEmpID(int empId) {
		Optional<Emp> result = emp.findById(empId);
		return result;
	}

	public void deleteByEmpId(int empId) {
		emp.deleteByEmpId(empId);
	}

	public void updateByEmpId(int empId, double modifiedSalary) {
		emp.updateByEmpId(empId,modifiedSalary);
	}

	public List<Emp> findAllOrderBySalary() {
		return this.findAll().stream()
				.sorted((x,y)->{
					return new Double(x.getSalary()).compareTo(new Double(y.getSalary()));
				}).toList();
	}

	public List<Emp> findAllOrderByName() {
		return this.findAll().stream().sorted((x,y)->{
			return x.getName().compareTo(y.getName());
		}).toList();
	}

}
