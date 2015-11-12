class User < ActiveRecord::Base
  # Include default devise modules. Others available are:
  # :confirmable, :lockable, :timeoutable and :omniauthable
  devise :database_authenticatable, :registerable,
         :recoverable, :rememberable, :trackable, :validatable

	has_many :sent_messages, :class_name => 'Message', :foreign_key => 'sender_id'
	has_many :recieved_messages, :class_name => 'Message', :foreign_key => 'reciever_id'
	has_many :assigned_task, :class_name => 'Task', :foreign_key => 'assigner_id'
	has_many :assigned_to_task, :class_name => 'Task', :foreign_key => 'assignee_id
end
