# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#
# Examples:
#
#   cities = City.create([{ name: 'Chicago' }, { name: 'Copenhagen' }])
#   Mayor.create(name: 'Emanuel', city: cities.first)


User.create(fname: 'karim',email: 'karim@gmail.com', password: '12345678', password_confirmation: '12345678') 
User.create(fname: 'Ahmed',email: 'ahmed@gmail.com', password: '87654321', password_confirmation: '87654321')
User.create(fname: 'Yasser',email: 'Yasser@gmail.com', password: '13131313', password_confirmation: '13131313')
User.create(fname: 'Mohamed', email: 'Mohamed@gmail.com', password: 'abcdefjhi',password_confirmation:'abcdefjhi')
User.create(fname: 'Sherif', email:'sherif@gmail.com', password: 'testtest', password_confirmation: 'testtest)

Task.create(title: 'Create evaluation DB', assignee_id: 2 , assigner_id: 1)
Task.create(title: 'Fix conflicts', assignee_id: 2 , assigner_id: 1)
Task.create(title: 'Create conflicts', assignee_id: 2 , assigner_id: 1)
Task.create(title: 'Do nothing', assignee_id: 1 , assigner_id: 3)
Task.create(title: 'Order pizza', assignee_id: 1 , assigner_id: 4)
Task.create(title: 'wash my car', assignee_id: 1 , assigner_id: 5)
