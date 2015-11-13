class User < ActiveRecord::Base
  # Include default devise modules. Others available are:
  # :confirmable, :lockable, :timeoutable and :omniauthable
  devise :database_authenticatable, :registerable,
         :recoverable, :rememberable, :trackable, :validatable
  validate :date_of_birth_cant_be_future

	has_many :sent_messages, :class_name => 'Message', :foreign_key => 'sender_id'
  has_many :recieved_messages, :class_name => 'Message', :foreign_key => 'reciever_id'
  has_many :has_tasks_assigned, :class_name => 'Task', :foreign_key => 'assignee_id'
  has_many :assigned_tasks_to, :class_name => 'Task', :foreign_key => 'assigner_id'
  has_many :host, :class_name => 'Event', :foreign_key => 'user_id'
  has_many :joined_awgs, :class_name => 'Awg', :foreign_key => 'awg_id'

  attr_accessor :fname

	def full_name
    	[fname, lname].join(' ')
	end


  def date_of_birth_cant_be_future
    if dateOfBirth > Date.today
      errors.add(:dateOfBirth, "Date of birth cant be in the future")
    end
  end
scope:get_members,lambda{|query| where(["committee LIKE ?","%#{query}%"])}
end
