package ru.mirea.task2;

import java.time.LocalDate;

public class Human
{
    private int age;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int weight;

    Human(String firstName, String lastName, LocalDate birthDate, int weight)
    {
        this.age = this.calculateAge(birthDate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public int calculateAge(LocalDate birthDate)
    {
        return ((LocalDate.now().getDayOfYear() < birthDate.getDayOfYear()) ? LocalDate.now().getYear() - birthDate.getYear() - 1 : LocalDate.now().getYear() - birthDate.getYear());
    }

    public int getAge()
    {
        return age;
    }

    public int getWeight()
    {
        return weight;
    }

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    public String toString()
    {
        return this.getFirstName() + "\t" +
                this.getLastName() + "\t" +
                this.getAge() + "\t" +
                this.getBirthDate() + "\t" +
                this.getWeight();
    }
}
