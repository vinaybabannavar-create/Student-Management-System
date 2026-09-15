package com.studentmanagement;

import jakarta.persistence.EntityManager;

public class StudentDAO {

    // CREATE
    public void addStudent(Student student) {

        EntityManager entityManager = JPAUtil.getEntityManager();

        try {

            entityManager.getTransaction().begin();

            entityManager.persist(student);

            entityManager.getTransaction().commit();

            System.out.println();
            System.out.println("Student added successfully!");
            System.out.println("Student ID: " + student.getStudentId());

        } catch (Exception e) {

            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }

            System.out.println("Error adding student!");
            e.printStackTrace();

        } finally {

            entityManager.close();
        }
    }

    // READ
    public void viewStudent(int studentId) {

        EntityManager entityManager = JPAUtil.getEntityManager();

        try {

            Student student = entityManager.find(
                    Student.class,
                    studentId);

            if (student != null) {

                System.out.println();
                System.out.println("Student Details");
                System.out.println("-----------------------------");

                System.out.println(
                        "ID     : " + student.getStudentId());

                System.out.println(
                        "Name   : " + student.getStudentName());

                System.out.println(
                        "Email  : " + student.getEmail());

                System.out.println(
                        "Course : " + student.getCourse());

                System.out.println(
                        "Phone  : " + student.getPhoneNumber());

                System.out.println("-----------------------------");

            } else {

                System.out.println("Student not found!");

            }

        } catch (Exception e) {

            System.out.println("Error viewing student!");
            e.printStackTrace();

        } finally {

            entityManager.close();
        }
    }

    // UPDATE
    public void updateStudent(
            int studentId,
            String newCourse,
            String newPhone) {

        EntityManager entityManager = JPAUtil.getEntityManager();

        try {

            entityManager.getTransaction().begin();

            Student student = entityManager.find(
                    Student.class,
                    studentId);

            if (student != null) {

                student.setCourse(newCourse);
                student.setPhoneNumber(newPhone);

                entityManager.getTransaction().commit();

                System.out.println();
                System.out.println("Student updated successfully!");

            } else {

                entityManager.getTransaction().rollback();

                System.out.println("Student not found!");

            }

        } catch (Exception e) {

            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }

            System.out.println("Error updating student!");
            e.printStackTrace();

        } finally {

            entityManager.close();
        }
    }

    // DELETE
    public void deleteStudent(int studentId) {

        EntityManager entityManager = JPAUtil.getEntityManager();

        try {

            entityManager.getTransaction().begin();

            Student student = entityManager.find(
                    Student.class,
                    studentId);

            if (student != null) {

                entityManager.remove(student);

                entityManager.getTransaction().commit();

                System.out.println();
                System.out.println("Student deleted successfully!");

            } else {

                entityManager.getTransaction().rollback();

                System.out.println("Student not found!");

            }

        } catch (Exception e) {

            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }

            System.out.println("Error deleting student!");
            e.printStackTrace();

        } finally {

            entityManager.close();
        }
    }
}