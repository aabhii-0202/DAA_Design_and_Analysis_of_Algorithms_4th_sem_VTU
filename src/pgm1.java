/*program 1
1a Create a java class student with the following details as variables within it
1. usn
2. name
3. branch
4. phone
write a java program to create n student objects and print the usn ,name ,branch, phone
if these objects with suitable heading
*/
class students {
    String usn ,name,branch ,phone;
    public students(String u,String n,String b,String p){
        this.usn=u;
        this.name=n;
        this.branch=b;
        this.phone=p;
    }
    void disp(){
        System.out.println("\n Student details:");
        System.out.println("USN = "+this.usn);
        System.out.println("Name = "+this.name);
        System.out.println("Branch = "+this.branch);
        System.out.println("Phone = "+this.phone);
    }
}
class pgm1{
    public static void main(String[] args) {
        students s1= new students("1RN19IS001","AMAN","ISE","9933");
        students s2= new students("1RN19IS002","Abhi","ISE","1340");
        s1.disp();
        s2.disp();

    }

}