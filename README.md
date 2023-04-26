# DOCTOR BOOKING API


### Frameworks,Technology and Language used:
* Spring
* Spring boot
* Java
* Hibernate-JPA
* SQL


### Data Flow
* Controller :
  * This API has 6 controller classes which includes:
     * DoctorController : This controller is used to manage the list of doctors.
     * PatientController: This controller is used to manage the list of patients.
     * SpecialityController: This controller is used to manage the list of specialities available for the doctors.
     * CityContoller : This controller is used to manage the list of cities available.
     * SymptomsContoller : This controller is used to create new symptoms for the patients.
     * BookingController: This controller is used to suggest the list of doctors available for that patients symptoms and city.
* Service
  *  This API has 6 service classes which includes:
     * DoctorService
     * PatientService
     * SpecialityService
     * CityService
     * SymptomsService
     * BookingService  
* Repository
  * This API has 5 repository interfaces which includes:
     * DoctorRepository
     * PatientRepository
     * SpecialityRepository
     * SymptomsRepository
     * CityRepository


### Project Summary
This is a doctor booking api. This api has functions such as adding cities, doctors, patients, symptoms and specialities. The patient can then search for the list of doctors
available in their city for their particular symtoms.
