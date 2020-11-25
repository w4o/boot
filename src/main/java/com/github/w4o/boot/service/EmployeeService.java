package com.github.w4o.boot.service;

import com.github.w4o.boot.ao.SearchEmployeeParam;
import com.github.w4o.boot.domain.Employee;
import com.github.w4o.boot.repository.EmployeeRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author frank
 * @date 2020/4/29
 */
@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Page<Employee> list(SearchEmployeeParam searchEmployeeParam) {
        Sort sort = Sort.by(Sort.Direction.DESC, "inTheDate");
        Pageable pageable = PageRequest.of(searchEmployeeParam.getPage() - 1, searchEmployeeParam.getSize(), sort);

        return employeeRepository.findAll((root, query, cb) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(cb.equal(root.get("deleted"), false));

            if (!StringUtils.isEmpty(searchEmployeeParam.getName())) {
                list.add(cb.like(root.get("name"), "%" + searchEmployeeParam.getName() + "%"));
            }

            //TODO

            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }, pageable);

    }
}
