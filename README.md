# SupportUserAdmin


Step 1: Register Users and Admins
==================================
Register a User
Endpoint: POST /users/register
Input (JSON):
json
Copy code
{
  "username": "john_doe",
  "password": "password123"
}


Expected Response:
json
Copy code
{
  "id": 1,
  "username": "john_doe",
  "password": "password123",
  "role": "USER"
}


Register an Admin
=================
Endpoint: POST /admins/register
Input (JSON):
json
Copy code
{
  "username": "admin_alok",
  "password": "adminpass"
}


Expected Response:
json
Copy code
{
  "id": 2,
  "username": "admin_alok",
  "password": "adminpass",
  "role": "ADMIN"
}


Step 2: Login Users and Admins
===========================
Login as User
Endpoint: POST /users/login
Input (Query Parameters):
makefile
Copy code
username=john_doe
password=password123


Expected Response:
json
Copy code
{
  "id": 1,
  "username": "john_doe",
  "role": "USER"
}
Login as Admin
================
Endpoint: POST /admins/login
Input (Query Parameters):
makefile
Copy code
username=admin_alok
password=adminpass


Expected Response:
json
Copy code
{
  "id": 2,
  "username": "admin_alok",
  "role": "ADMIN"
}


Step 3: Upload Assignments
===============================
Upload an Assignment as a User
Endpoint: POST /users/upload
Input (JSON):
json
Copy code
{
  "userId": "john_doe",
  "task": "Complete the HelloWorld program",
  "admin": "admin_alok"
}


Expected Response:
json
Copy code
{
  "id": 1,
  "userId": "john_doe",
  "task": "Complete the HelloWorld program",
  "admin": "admin_alok",
  "status": "Pending",
  "submittedAt": "2024-11-16T10:00:00"
}


Step 4: View Assignments (Admin)
=====================================
Get Assignments Tagged to an Admin
Endpoint: GET /admins/assignments
Input (Query Parameters):
makefile
Copy code
admin=admin_alok


Expected Response:
json
Copy code
[
  {
    "id": 1,
    "userId": "john_doe",
    "task": "Complete the HelloWorld program",
    "admin": "admin_alok",
    "status": "Pending",
    "submittedAt": "2024-11-16T10:00:00"
  }
]


Step 5: Update Assignment Status
===================================
Accept an Assignment
Endpoint: POST /admins/assignments/{id}/accept
Input: None (Path Variable: id=1)
Expected Response:
json
Copy code
{
  "id": 1,
  "userId": "john_doe",
  "task": "Complete the HelloWorld program",
  "admin": "admin_alok",
  "status": "Accepted",
  "submittedAt": "2024-11-16T10:00:00"
}

Reject an Assignment
=======================
Endpoint: POST /admins/assignments/{id}/reject
Input: None (Path Variable: id=1)
Expected Response:
json
Copy code
{
  "id": 1,
  "userId": "john_doe",
  "task": "Complete the HelloWorld program",
  "admin": "admin_alok",
  "status": "Rejected",
  "submittedAt": "2024-11-16T10:00:00"
}


Step 6: Delete an Assignment
=============================
Delete an Assignment
Endpoint: DELETE /admins/assignments/{id}
Input: None (Path Variable: id=1)
Expected Response:
json
Copy code
{
  "message": "Assignment deleted successfully"
}


Step 7: Retrieve Admins
==========================
Endpoint: GET /users/admins
Expected Response:
json
Copy code
[
  {
    "id": 2,
    "username": "admin_alok",
    "role": "ADMIN"
  }
]
