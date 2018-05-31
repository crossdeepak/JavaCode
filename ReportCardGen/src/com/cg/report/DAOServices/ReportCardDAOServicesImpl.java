package com.cg.report.DAOServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cg.report.beans.Student;
import com.cg.report.beans.Subject;
import com.cg.report.utility.ReportCardUtility;

public class ReportCardDAOServicesImpl implements ReportCardDAOServices {
	private static HashMap<Integer, Student>students=new HashMap<>();
	@Override
	public int insertStudent(Student student) {
		students.put(student.getId(), student);
		students.get(student).setId(ReportCardUtility.SUBJECT_ID_COUNTER++);
//		student.setId(ReportCardUtility.SUBJECT_ID_COUNTER++);
		return student.getId();
	}

	@Override
	public int insertSubject(int studentId, Subject subject) {
		students.get(studentId).getSubjects().put(ReportCardUtility.SUBJECT_ID_COUNTER, subject);
		students.get(studentId).getSubjects().get(ReportCardUtility.SUBJECT_ID_COUNTER).setId(ReportCardUtility.SUBJECT_ID_COUNTER++);
		return subject.getId();
	}

	@Override
	public boolean updateStudent(int studentId, Student student) {
		students.put(student.getId(), student);
		return true;
	}

	@Override
	public boolean deleteStudent(int studentId) {
		students.remove(studentId);
		return true;
	}

	@Override
	public Student getStudent(int studentId) {
		return students.get(studentId);
	}

	@Override
	public Subject getSubject(int studentId, int subjectId) {
		return students.get(studentId).getSubjects().get(subjectId);
	}

	@Override
	public List<Student> getStudents() {
		List<Student>studentList=new ArrayList<>(students.values());
		return studentList;
	}

	@Override
	public List<Subject> getSubjects(int studentId) {
		List<Subject>subjectList=new ArrayList<>(students.get(studentId).getSubjects().values());
		return subjectList;
	}

}
