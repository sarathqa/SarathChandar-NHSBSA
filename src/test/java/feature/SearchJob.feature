Feature: Test NHS Job Search functionality

  Background:
    Given JobSeeker landed on NHS Job Portal

  @Smoke  @Regression @Sanity
  Scenario Outline: JobSeeker searches jobs by Job title on NHS portal, sorts results by newest date posted, and verifies that job listings should be displayed with the most recent postings with their preference.
    And Enter "<JobTitle>" keyword in the Job Title field
    And Click search button
    Then Verify that Jobseeker should be able to see the list of jobs based on "<JobTitle>" keyword
    And Sort the result with "<sortType>"
    And List down all job title in the first page for "<JobTitle>" keyword
    Examples:
      | JobTitle           | sortType             |
      | Activity Hub Coach | Date Posted (newest) |
      |Automation Testing|Date Posted (newest)|


  @Regression
  Scenario: JobSeeker searches jobs without any preference on NHS portal, sorts results by newest date posted, and verifies that job listings should be displayed with the most recent postings.
    And Click search button
    Then Verify that Jobseeker should be able to see the list of jobs based on "jobs found" keyword
    And Sort the result with "Date Posted (newest)"

  @Regression @Sanity
  Scenario Outline: JobSeeker searches jobs with multiple preference on NHS portal, sorts results by newest date posted, and verifies that job listings should be displayed with the most recent postings with their preference.
    And Enter "<JobTitle>" keyword in the Job Title field
    And Enter "<JobLoc>" keyword in the Job location field
    And Click search button
    Then Verify that Jobseeker should be able to see the list of jobs based on "<JobTitle>" keyword
    And Sort the result with "<sortType>"
    And List down all job title in the first page for "<JobTitle>" keyword
    Examples:
      | JobTitle                | JobLoc    | sortType             |
      | Automation Test Analyst | Liverpool | Date Posted (newest) |

  @Regression
  Scenario: JobSeeker searches jobs with invalid data on NHS portal and verifies that No Jobs should be listed in the portal
    And Enter "12345" keyword in the Job Title field
    And Click search button
    Then Verify that Jobseeker should be able to see the list of jobs based on "No result found" keyword

  @Smoke  @Regression
  Scenario Outline: JobSeeker searches jobs by Job location on NHS portal, sorts results by newest date posted, and verifies that job listings should be displayed with the most recent postings with their preference.
    Then Verify that distance drop down should be "disabled"
    And Enter "<JobLoc>" keyword in the Job location field
    Then Verify that distance drop down should be "enabled"
    Then Verify the drop down values from Job Distance
    And Select "<Distance>" distance
    And Click search button
    Then Verify that Jobseeker should be able to see the list of jobs based on "<JobLoc>" keyword
    And Sort the result with "<sortType>"
    And List down all job title in the first page for "<JobLoc>" keyword
    Examples:
      | JobLoc             | Distance  | sortType             |
      | Lock Hill, Grimsby | +20 Miles | Date Posted (newest) |

  @Regression
  Scenario: JobSeeker enter the details in NHS portal and should be able to reset the details by clicking clear filter button
    And Enter "Automation Test Analyst" keyword in the Job Title field
    And Enter "Lock Hill, Grimsby" keyword in the Job location field
    And Select "+20 Miles" distance
    And Click clear button
    Then Verify that entered value should not be displayed in Job Title field
    Then Verify that entered value should not be displayed in Job Location field

  @Regression
  Scenario: JobSeeker click More Search options link and verify that Job reference, Employer and pay range field should be displayed
    And Click More Search options link
    Then Verify that Job Reference, Employer and Pay fields should be displayed and enabled

  @Regression
  Scenario Outline: JobSeeker searches jobs by Employer and Pay on NHS portal, sorts results by newest date posted, and verifies that job listings should be displayed with the most recent postings with their preference.
    And Click More Search options link
    And Enter "<Employer>" keyword in the Employer field
    And Select "<Pay>" in the Pay Range field
    And Click search button
    And List down all job title in the first page for "<Employer>" keyword
    Examples:
      | Employer             | Pay  |
      | NHS Business Service Authority | £10,000 to £20,000 |

  @Smoke @Regression
  Scenario: JobSeeker switch to the Cymraeg language and verify that label name of all fields should be displayed in Cymraeg language
    And Click Cymraeg language
    Then Verify that Label name of Job Reference, Job Location and distance should be displayed in Cymraeg
