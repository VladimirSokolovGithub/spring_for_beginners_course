package ru.sokolov.spring.chapter_3_HibernateBasics.Les_15_Types_of_data_upload_Eager_and_Lazy.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String departmentName;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "min_salary")
    private int minSalary;

    //Работников в департаменте может быть много, поэтому мы можем использовать List работников

    // Кроме типа каскада и указателя на Foreign Key мы так же можем указать Fetch Type - тип
    // выборки (EAGER или LAZY). Так же если не указывать Fetch Type(тип выборки), то существуют
    // типы выборки по умолчанию для каждого из типа связей - смотри слайд №3

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.EAGER)

    // Теперь поменяем EAGER на LAZY и посмотрим что получится в Test12 в примере кода 2
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.LAZY)

    private List<Employee> emps;

    public Department() {
    }

    public Department(String departmentName, int maxSalary, int minSalary) {
        this.departmentName = departmentName;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    //Из за того, что это Bi-Directional связь мы должны employee из параметра метода, прописать,
    // что его департамент this т.е объект(department) на котором мы будем вызывать метод
    // addEmployeeToDepartment именно этот департамент будет департаментом работника которого
    // мы будем добавлять.

    public void addEmployeeToDepartment(Employee employee){
        if(emps == null){
            emps = new ArrayList<>();
        }
        emps.add(employee);
        employee.setDepartment(this); //вот здесь мы прописываем Bi-Directional связь между
                                      // работником и департаментом
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", maxSalary=" + maxSalary +
                ", minSalary=" + minSalary +
                '}';
    }
}
