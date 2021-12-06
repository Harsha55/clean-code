package com.b.simple.design.business.student;
public class StudentHelper {

	public static final int GRADE_B_LOWER_LIMIT = 51;
	public static final int GRADE_B_UPPER_LIMIT = 80;

	/* PROBLEM 1 */
	/*
	* You get a grade B if marks are between 51 and 80 (both inclusive). Except for Maths where the upper limit is increased by 10.
	*/
	public boolean isGradeB(int marks, boolean isMaths) {
		int extraScore = isMaths ? 10 : 0;
		int upperLimit = GRADE_B_UPPER_LIMIT + extraScore;
		return marks >= GRADE_B_LOWER_LIMIT && marks <= upperLimit;
	}

	/* PROBLEM 2 */
	/*
	You are awarded a grade based on your marks.
	Grade A = 91 to 100, Grade B = 51 to 90, Otherwise Grade C
	Except for Maths where marks to get a Grade are 5 higher than required for other subjects.
	*/

	public String getGrade(int mark, boolean isMaths) {
		int extraLimit = isMaths ? 5 : 0;

		if (mark >= 91 + extraLimit)
			return "A";
		if (mark >= 51 + extraLimit) {
			return  "B";
		}
		return "C";
	}

	/*  PROBLEM 3
     * You and your Friend are planning to enter a Subject Quiz.
     * However, there is a marks requirement that you should attain to qualify.
     * 
     * Return value can be YES, NO or MAYBE.
     * 
     * YES If either of you are very good at the subject(has 80 or more marks)
     * However, there is an exception that if either of you is not good in the subject(20 or less marks), it is NO.
     * In all other conditions, return MAYBE.
     * 
     * However, the definition for good and not good are 5 marks higher if the subject is Mathematics.
     * 
     * marks1 - your marks
     * marks2 - your friends marks
    */
        
    public String willQualifyForQuiz(int marks1, int marks2, boolean isMaths) {
		int extraLimit = isMaths ? 5 : 0;
		final int assuredQualifiedLimit = 80 + extraLimit;
		final int notQualifiedLimit = 20 + extraLimit;

		if ( marks1 <= notQualifiedLimit || marks2 <= notQualifiedLimit) return "NO";
		if (marks1 >= assuredQualifiedLimit || marks2 >= assuredQualifiedLimit) return "YES";
        return "MAYBE";
    }	

}