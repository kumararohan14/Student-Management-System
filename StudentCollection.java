import java.util.Arrays;
public class StudentCollection{
	private Student[] studentsArray = new Student[0];
	
	public boolean addStudent(Student student){
		
		if(student != null){
			incrementStudentArray();
			studentsArray[studentsArray.length-1]=student;
			System.out.println(student.getName());
			System.out.println(Arrays.toString(studentsArray));
			return true;
			
		}else{
			return false;
		}
	}
	
	public void incrementStudentArray() {
		Student[] tempStudentIdArray=new Student[studentsArray.length+1];
		for(int j=0; j<studentsArray.length; j++){
			tempStudentIdArray[j]=studentsArray[j];
		}
		studentsArray=tempStudentIdArray;
	}
		
	
}
