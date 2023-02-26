# CRUD-with-Many-relationships

## Framework And language used
- SpringBoot
- Java
## Data Flow
### Model
- 1- Student 
- 2- Laptop
- 3- Address
- 4- Book
- 5- Course

### Controller
- 1- StudentController
- 2- LaptopController
- 3- CourseController
- 4- BookController

### Service
- 1- StudentService
- 2- LaptopService
- 3- CourseService
- 4- BookService

### Repository
- 1- StudentRepository
- 2- LaptopRepository
- 3- CourseRepository
- 4- BookRepository

### Database Design
- Here we are using the MYSQL DataBase and it is in a Tabular Form

## Project Summary
In this Project CRUD operations are performed by hitting the API and here are the links for different model:

1) Student
- PostMapping -> http://localhost:8080/student/saveStudent
- GetMapping -> http://localhost:8080/student/getStudent
- GetMapping -> http://localhost:8080/student/getStudentById/{Id}
- PutMapping -> http://localhost:8080/student/updateStudent/{Id}
- DeleteMapping -> http://localhost:8080/student/deleteStudentById/{Id}

2) Laptop
- PostMapping -> http://localhost:8080/laptop/saveLaptop
- GetMapping - > http://localhost:8080/laptop/getLaptop
- GetMapping -> http://localhost:8080/laptop/getLaptopById/{Id}
- PutMapping -> http://localhost:8080/laptop/updateLaptop/{Id}
- DeleteMapping -> http://localhost:8080/laptop/deleteLaptopById/{Id}

3) Course
- PostMapping -> http://localhost:8080/course/saveCourse
- Getmapping -> http://localhost:8080/course/getCourse
- GetMapping (by Id) -> http://localhost:8080/course/getCourseById/{Id}
- PutMapping -> http://localhost:8080/course/updateCourse/{Id}
- DeleteMapping -> http://localhost:8080/course/deleteCourseById/{Id}

4)  Book
- PostMapping -> http://localhost:8080/book/saveBook
- GetMapping  -> http://localhost:8080/book/getBook
- GetMapping  -> http://localhost:8080/book/getBookById/{Id}
- PutMapping -> http://localhost:8080/book/updateBook/{Id}
- DeleteMapping -> http://localhost:8080/book/deleteBookById/{Id}
