// Study Link : https://github.com/Akashpal95/design-patterns?tab=readme-ov-file

/** Builder Design Pattern
 * 1. It deals with, how to create complex classes with lots of attributes.
 */

 /** How to create class with lots of attributes */

 import java.util.Date;
import java.util.HashMap;
import java.util.List;
 
 public class Student {
     private String name;
     private int age;
     private int psp;
     private long phone;
     private String address;
     private String email;
     private String gender;
     private Date dateOfBirth;
     private String studentId;
     private double gpa;
     private String major;
     private List<String> courses;
     private Date admissionDate;
     private String parentInfo;
 

     // Getter and setter for 'name' property
     public String getName() {
         return name;
     }
 
     public void setName(String name) {
         this.name = name;
     }
 
     // Getter and setter for 'age' property
     public int getAge() {
         return age;
     }
 
     public void setAge(int age) {
         this.age = age;
     }
 
     // Getter and setter for 'psp' property
     public int getPsp() {
         return psp;
     }
 
     public void setPsp(int psp) {
         this.psp = psp;
     }
 
     // Getter and setter for 'phone' property
     public long getPhone() {
         return phone;
     }
 
     public void setPhone(long phone) {
         this.phone = phone;
     }
 
     // Getter and setter for 'address' property
     public String getAddress() {
         return address;
     }
 
     public void setAddress(String address) {
         this.address = address;
     }
 
     // Getter and setter for 'email' property
     public String getEmail() {
         return email;
     }
 
     public void setEmail(String email) {
         this.email = email;
     }
 
     // Getter and setter for 'gender' property
     public String getGender() {
         return gender;
     }
 
     public void setGender(String gender) {
         this.gender = gender;
     }
 
     // Getter and setter for 'dateOfBirth' property
     public Date getDateOfBirth() {
         return dateOfBirth;
     }
 
     public void setDateOfBirth(Date dateOfBirth) {
         this.dateOfBirth = dateOfBirth;
     }
 
     // Getter and setter for 'studentId' property
     public String getStudentId() {
         return studentId;
     }
 
     public void setStudentId(String studentId) {
         this.studentId = studentId;
     }
 
     // Getter and setter for 'gpa' property
     public double getGpa() {
         return gpa;
     }
 
     public void setGpa(double gpa) {
         this.gpa = gpa;
     }
 
     // Getter and setter for 'major' property
     public String getMajor() {
         return major;
     }
 
     public void setMajor(String major) {
         this.major = major;
     }
 
     // Getter and setter for 'courses' property
     public List<String> getCourses() {
         return courses;
     }
 
     public void setCourses(List<String> courses) {
         this.courses = courses;
     }
 
     // Getter and setter for 'admissionDate' property
     public Date getAdmissionDate() {
         return admissionDate;
     }
 
     public void setAdmissionDate(Date admissionDate) {
         this.admissionDate = admissionDate;
     }
 
     // Getter and setter for 'parentInfo' property
     public String getParentInfo() {
         return parentInfo;
     }
 
     public void setParentInfo(String parentInfo) {
         this.parentInfo = parentInfo;
     }
 }
 

 Student s = new Student(); // This initialies emoty object creation.
 s.setName();
 s.setAge();
 s.setPsp();

 /** Issues in the above approch
  * 1. Empty Object Creation: 
        When you create a Student object without initializing any of its attributes, you risk having an object with default values or null values for its attributes. 
        This could lead to unexpected behavior or errors if any attributes are accessed before being properly initialized.
  * 2. Lack of Validations: 
        Without proper validations, there is no mechanism to ensure that the values assigned to the attributes are valid or within acceptable ranges. For example, age should typically be a positive integer, phone number should be a valid phone number format, etc. 
        Without validations, invalid data could be set for the attributes, leading to inconsistencies or errors later on.
  */

/** Solution
 * 1. We can have parameterized constructor, i.e default constructor won't be present, which will avoid creating empty object.
 */

 public class Student {
    private String name;
    private int age;
    private int psp;
    private long phone;
    private String address;
    private String email;
    private String gender;
    private Date dateOfBirth;
    private String studentId;
    private double gpa;
    private String major;
    private List<String> courses;
    private Date admissionDate;
    private String parentInfo;

    // Constructor
    public Student(String name, int age, int psp, long phone, String address, String email,
                   String gender, Date dateOfBirth, String studentId, double gpa, String major,
                   List<String> courses, Date admissionDate, String parentInfo) {
        this.name = name;
        this.age = age;
        this.psp = psp;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.studentId = studentId;
        this.gpa = gpa;
        this.major = major;
        this.courses = courses;
        this.admissionDate = admissionDate;
        this.parentInfo = parentInfo;
    }
}

/** Issues with above
 * 1. There too many agruments or parameters, image having more than 20. It would be difficult to maintain and make changes.
 * 2. Suppose, if you just want to initialize with only few agruments like 
 *      a. Student s = new Student("sonu",20,10) // name, 20, 10
 *      b. Student s = new Student(8736738876,"tetst@gmail.com") // phone, email
 *      there could be many constructor created for such combination. it could be 2**N combination, which is not possible to have.
 * 3. Order of params has to be maintained
 * 4. Prones to error, since you need to check class defination for each costructor multiple times
 * 5. New params adding leads to mulitple problems, like, whereever you have instanciated the class, addition of new params which requiried changes at each places of the code
  */

  /** Idea One
   * 1. What if you club all the parameters together in a single data struckture, like key and value i.e (key,value)
   */

   /** Create a map (which will act like a dictionary or object and will store value in key,value pairs) and then pass it as a object to constructor */
   HashMap<String,Object> map = new HashMap<>();
   map.put("name","sonu");
   map.put("age",20);

   if(map.containsKey("name")){
    // add validation logic here
   }

   /** Issues
    * 1. map.put("naem","sonu") // key name can be misspelled
    * 2. map.put("age","38") // value, data type can be entered wrong
    */
/** Idea for solution
 * 1. Think of something like a map, which runs at compile time and check key values (key name and data type) 
 * 2. You can think of, customer Datatype or custom classes.
 * 3. Instead of map, you can use custom classes
 */

 public class Builder {
    private String name;
    private int age;
    private int psp;
    private long phone;
    private String address;
    private String email;
    private String gender;
    private Date dateOfBirth;
    private String studentId;
    private double gpa;
    private String major;
    private List<String> courses;
    private Date admissionDate;
    private String parentInfo;

    // Getter and setter for 'name' property
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for 'age' property
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter and setter for 'psp' property
    public int getPsp() {
        return psp;
    }

    public void setPsp(int psp) {
        this.psp = psp;
    }

    // Getter and setter for 'phone' property
    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    // Getter and setter for 'address' property
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and setter for 'email' property
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and setter for 'gender' property
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Getter and setter for 'dateOfBirth' property
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Getter and setter for 'studentId' property
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // Getter and setter for 'gpa' property
    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    // Getter and setter for 'major' property
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    // Getter and setter for 'courses' property
    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    // Getter and setter for 'admissionDate' property
    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    // Getter and setter for 'parentInfo' property
    public String getParentInfo() {
        return parentInfo;
    }

    public void setParentInfo(String parentInfo) {
        this.parentInfo = parentInfo;
    }
}

Builder b = new Builder();
b.setName("sonu")
b.setAge(20)
.
.
.
n
// and then apply validation
// We can still improve our solution




/** Builder Class */

package DesignPatterns.BuilderPattern;

public class Builder {
    String name;
    int age;
    int psp;
    String univName;
    long phnNo;
    int gradYear;


//    public Student build() throws Exception{
//        return new Student(this);
//    }

    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    public Builder setAge(int age) {
        this.age = age;
        return this;
    }

    public Builder setPsp(int psp) {
        this.psp = psp;
        return this;
    }

    public Builder setUnivName(String univName) {
        this.univName = univName;
        return this;
    }

    public Builder setPhnNo(long phnNo) {
        this.phnNo = phnNo;
        return this;
    }

    public Builder setGradYear(int gradYear) {
        this.gradYear = gradYear;
        return this;
    }
}



/** Student Class */

package DesignPatterns.BuilderPattern;

import javax.xml.validation.Validator;

public class Student {
    String name;
    int age;
    int psp;
    String univName;
    long phnNo;
    int gradYear;

    public static Builder getBuilder(){
        return new Builder();
    }

    private Student(Builder studB) throws Exception{
        if(studB.name != null){
            if(studB.name.length() <= 1){
                throw new Exception("Validation Failed");
            }
        }

        if(studB.age < 20){
            throw  new Exception("Validation Failed");
        }

        if(studB.phnNo ==123456789){
            throw new Exception("Invalid");
        }


        this.name = studB.name;
        this.age = studB.age;
        this.psp = studB.psp;
        this.univName = studB.univName;
        this.phnNo = studB.phnNo;
        this.gradYear = studB.gradYear;

    }

    public static class Builder {
        String name;
        int age;
        int psp;
        String univName;
        long phnNo;
        int gradYear;

        public Student build() throws Exception{
            return new Student(this);
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setPsp(int psp) {
            this.psp = psp;
            return this;
        }

        public Builder setUnivName(String univName) {
            this.univName = univName;
            return this;
        }

        public Builder setPhnNo(long phnNo) {
            this.phnNo = phnNo;
            return this;
        }

        public Builder setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }
    }

}


/** Client Class */

package DesignPatterns.BuilderPattern;

public class Client {

    public static void main(String[] args) {

        try {


            //Solution 1
//            Builder b = new Builder();
//            b.setName("Akash");
//            b.setAge(20);
//            Student s = new Student(b);

            //Solution 2
//            Builder b = Student.getBuilder()
//                    .setAge(20)
//                    .setName("Akash")
//                    .setGradYear(2020)
//                    .setPsp(1)
//                    .setUnivName("SRM");
//            Student s = new Student(b);
//
            //Solution 3
//            Student s = new Student(Student.getBuilder()
//                    .setAge(20)
//                    .setName("Akash")
//                    .setGradYear(2020)
//                    .setPsp(1)
//                    .setUnivName("SRM"));

            //Solution 4
            Student s = Student.getBuilder()
                    .setAge(20)
                    .setName("Akash")
                    .setGradYear(2020)
                    .setPsp(1)
                    .setUnivName("SRM")
                    .build();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/////////////////////////////////////

package com.assignment.question;

public class Query {

    private String select;
    private String from;
    private String where;
    private String join;
    private String orderBy;
    private String groupBy;

    public Query(String select, String from, String where, String join, String orderBy, String groupBy) {
        this.select = select;
        this.from = from;
        this.where = where;
        this.join = join;
        this.orderBy = orderBy;
        this.groupBy = groupBy;
    }

    public String getSelect() {
        return select;
    }

    public String getFrom() {
        return from;
    }

    public String getWhere() {
        return where;
    }

    public String getJoin() {
        return join;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public String getGroupBy() {
        return groupBy;
    }
}


package com.assignment.question;

// This class uses the Builder design pattern to create instances of the QueryBuilder class
@WithBuilder
public class QueryBuilder {

    // These are the properties of a SQL query
    private String select;
    private String from;
    private String where;
    private String join;
    private String orderBy;
    private String groupBy;

    // This private constructor is used by the Builder to create an instance of QueryBuilder
    private QueryBuilder(Builder builder){
      this.select = builder.getSelect();
      this.from = builder.getFrom();
      this.where = builder.getWhere();
      this.join = builder.getJoin();
      this.orderBy = builder.getOrderBy();
      this.groupBy = builder.getGroupBy();
    }

    // This static method returns a new instance of the Builder
    public static Builder createBuilder(){
      return new Builder();
    }

    // This is the Builder class
    public static class Builder{
      // These fields correspond to the properties of the QueryBuilder class
      private String select;
      private String from;
      private String where;
      private String join;
      private String orderBy;
      private String groupBy;

      // Getter methods for each property

      public String getSelect() {
          return select;
      }

      public String getFrom() {
          return from;
      }

      public String getWhere() {
          return where;
      }

      public String getJoin() {
          return join;
      }

      public String getOrderBy() {
          return orderBy;
      }

      public String getGroupBy() {
          return groupBy;
      }

      // This method creates a new instance of QueryBuilder using the current state of the Builder
      public QueryBuilder build(){
        return new QueryBuilder(this);
      }
    }
}

///////////////////////////////////////////


package com.assignment.question;

public class DatabaseConfiguration {

    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

    public DatabaseConfiguration(String databaseUrl, String username, String password, int maxConnections, boolean enableCache, boolean isReadOnly) {
        this.databaseUrl = databaseUrl;
        this.username = username;
        this.password = password;
        this.maxConnections = maxConnections;
        this.enableCache = enableCache;
        this.isReadOnly = isReadOnly;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public boolean isEnableCache() {
        return enableCache;
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }
}

package com.assignment.question;

@WithBuilder
public class DatabaseConfigurationBuilder {
    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

    private DatabaseConfigurationBuilder(Builder builder){
        this.databaseUrl = builder.getDatabaseUrl();
        this.username = builder.getUsername();
        this.password = builder.getPassword();
        this.maxConnections = builder.getMaxConnections();
        this.enableCache = builder.isEnableCache();
        this.isReadOnly = builder.isReadOnly();
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        private String databaseUrl;
        private String username;
        private String password;
        private int maxConnections;
        private boolean enableCache;
        private boolean isReadOnly;

        public Builder settDatabaseUrl(String databaseUrl){
            this.databaseUrl = databaseUrl;
            return this;
        }

        public Builder setUsername(String username){
            this.username = username;
            return this;
        }

        public Builder getPassword(String password){
            this.password = password;
            return this;
        }

        public Builder getMaxConnections(int maxConnections){
            this.maxConnections = maxConnections;
            return this;
        }

        public Builder isEnableCache(boolean enableCache){
            this.enableCache = enableCache;
            return this;
        }

        public Builder isReadOnly(boolean isReadOnly){
            this.isReadOnly = isReadOnly;
            return this;
        }

        public String getDatabaseUrl(){
            return databaseUrl;
        }

        public String getUsername(){
            return username;
        }

        public String getPassword(){
            return password;
        }

        public int getMaxConnections(){
            return maxConnections;
        }

        public boolean isEnableCache(){
            return enableCache;
        }

        public boolean isReadOnly(){
            return isReadOnly;
        }

        public DatabaseConfigurationBuilder build() {
            return new DatabaseConfigurationBuilder(this);
        }
    }

}
