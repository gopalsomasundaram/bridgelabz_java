package ObjectModelling;
import java.util.ArrayList;

/* this class represents the Faculty member.
it is modeled using AGGREGATION. 
faculty members are independent individuals who can exist even if 
the university or department is closed.
*/
class Faculty {
    private String name;

    Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

/* this class represents the Department.
it is modeled using COMPOSITION relative to the University.
a department is a functional unit of a specific university and 
cannot exist without its parent institution.
*/
class DepartmentUni {
    private String deptName;
    private ArrayList<Faculty> facultyList;

    DepartmentUni(String deptName) {
        this.deptName = deptName;
        this.facultyList = new ArrayList<>();
    }

    /* aggregation logic: we pass an ALREADY EXISTING faculty object.
    the department does not 'own' the faculty member's lifecycle.
    */
    public void assignFaculty(Faculty faculty) {
        facultyList.add(faculty);
    }

    public void displayDepartment() {
        System.out.println("  Department: " + deptName);
        for (Faculty f : facultyList) {
            System.out.println("    - Faculty Member: " + f.getName());
        }
    }
}

/* this class represents the University (The Parent).
it demonstrates both relationships:
1. Composition with Departments (Created inside the University).
2. Aggregation with Faculty (Referenced by the University).
*/
class University {
    private String uniName;
    private ArrayList<DepartmentUni> departments;

    University(String uniName) {
        this.uniName = uniName;
        this.departments = new ArrayList<>();
    }

    /* composition logic: the Department is instantiated INSIDE the University.
    if the university is deleted, these department objects are lost.
    */
    public void addDepartment(String deptName) {
        DepartmentUni newDept = new DepartmentUni(deptName);
        departments.add(newDept);
    }

    // helper method to get a department to assign faculty to it
    public DepartmentUni getDepartment(int index) {
        return departments.get(index);
    }

    public void displayUniversity() {
        System.out.println("University: " + uniName);
        for (DepartmentUni d : departments) {
            d.displayDepartment();
        }
        System.out.println();
    }
}

/* the driver class demonstrates the lifecycle differences between 
composition (Departments) and aggregation (Faculty).
*/
public class UniversityHierarchy{
    public static void main(String[] args) {
        // 1. Aggregation: Create faculty members independently
        Faculty f1 = new Faculty("Dr. Smith");
        Faculty f2 = new Faculty("Prof. Johnson");

        // 2. Composition: Create the university
        University myUni = new University("Global Tech University");

        // 3. Composition: Departments are created as parts of the university
        myUni.addDepartment("Computer Science");
        myUni.addDepartment("Physics");

        // 4. Link Faculty to Departments
        myUni.getDepartment(0).assignFaculty(f1);
        myUni.getDepartment(1).assignFaculty(f2);

        myUni.displayUniversity();

        /* Demonstrating Lifecycle:
        we set the university to null (simulating deletion).
        */
        myUni = null;
        System.out.println("University has been deleted.");

        /* The Department objects are now unreachable (Composition).
        However, the Faculty objects still exist in memory because 
        they were created in the main method scope (Aggregation).
        */
        System.out.println("Faculty member " + f1.getName() + " still exists independently.");
    }
}