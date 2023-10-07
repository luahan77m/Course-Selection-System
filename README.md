# Course-Selection-System
This system provides a convenient set of course application and approval functions for students and teachers.

# Functions of the online course application module:
[Student login function]
Students with existing accounts can log in to the application system online.
User account data can be pre stored in the database.
[Online application function]
After the student logs in, select the course to apply for from the list of available courses.
Each application can only select one course and cannot be repeated.
When applying for a course, necessary application information should be filled in, such as the reason for application, upload proof, etc.
Detailed course data can be pre stored in a database.
[Applied courses, approval progress query function]
Applications during the approval process can be queried for progress.
The approval status includes: application submitted, course lecturer in process of approval, course supervisor in process of approval, approval successful, and application rejected.
After the approval is completed, which means that the approval status is either successful or rejected, students can click confirm to complete this application.
After completing this application, the application information will no longer be visible in the progress query function.
For courses that have been rejected, a new application can be resubmitted after offline communication.
[Query function of applied course approval records]
Students can access all the records they have applied for, including records of approval and rejection.
Application records can be displayed in pages and queried using multiple criteria.

# Online approval module function:
[Course application approval function]
Teachers with existing teacher role accounts can log in to the approval function.
The user segmentation of the teacher role is as follows: the course lecturer and supervisor, with the lecturer being the first approver of the course and the supervisor being the second approver.
The correspondence data between the main lecturer and the supervising teacher of the specific course can be stored in the database in advance.
If the submitted application does not meet the application requirements, it can be rejected, but the specific reason for rejection must be filled in so that students can submit a new application again.
[Approved Application Query Function]
Teachers can query approved applications, and the query results can be displayed in separate pages and queried using multiple criteria.

# Additional features：
[System backend]
System user management, course application course management, user approval authority management (relationship between courses and approved teachers), approval record query, export of approved records, and other functions.
[Create Approval Process]
According to specific requirements, a course approval process can be dynamically created, and approval steps and approvers for different types of courses can be dynamically specified.

# Expand demand
When designing a system, it is necessary to consider its scalability, compatibility, usability, universality, robustness, cross platform, and continuous integration, which not only meets existing needs but also adapts to future development capabilities.
