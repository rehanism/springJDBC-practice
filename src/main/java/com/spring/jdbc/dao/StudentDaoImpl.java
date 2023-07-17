package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	
	public int insert(Student student) {
		// inserting
        String query= "insert into student(id, name, city) values(?,?,?)";

        int r = this.jdbctemplate.update(query,student.getId(), student.getName(),student.getCity());
		return r;
	}
	
	public int update(Student student) {
		//updating
        String query= "update student set name=? , city=? where id=?";
        int r = this.jdbctemplate.update(query, student.getName(),student.getCity(),student.getId());
		return r;
	}
	
	public int delete(Student student) {
		// d
		String query= "delete from student where id=?";
        int r = this.jdbctemplate.update(query, student.getId());
		return r;
	}

	public Student getStudent(int studentId) {
		// selecting single student data
		String query=" select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbctemplate.queryForObject(query, rowMapper, studentId);
		return student;
		
	}
	public List<Student> getAllSudent() {
		// selecting all student data
		String query="Select * from student";
		List<Student> student = this.jdbctemplate.query(query, new RowMapperImpl());
		return student;
	}


	
	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}


	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}


}
