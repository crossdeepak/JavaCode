package com.cg.report.DAOServices;

import java.util.List;

import com.cg.report.beans.Student;
import com.cg.report.beans.Subject;

public interface ReportCardDAOServices {
	int insertStudent(Student student);
	int insertSubject(int studentId, Subject subject);
	boolean updateStudent(int studentId, Student student);
	boolean deleteStudent(int studentId);
	Student getStudent(int studentId);
	Subject getSubject(int studentId, int subjectId);
	List<Student> getStudents();
	List<Subject> getSubjects(int studentId);
}
