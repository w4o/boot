package com.github.w4o.boot.repository;

import com.github.w4o.boot.domain.Employee;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author frank
 * @date 2020/4/29
 */
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer>
        , JpaSpecificationExecutor<Employee> {
}
