class User < ActiveRecord::Base
  # Include default devise modules. Others available are:
  # :confirmable, :lockable, :timeoutable and :omniauthable
  devise :database_authenticatable, :registerable,
         :recoverable, :rememberable, :trackable, :validatable

  has_many :sent_messages, :class_name => 'Message', :foreign_key => 'sender_id'
  has_many :recieved_messages, :class_name => 'Message', :foreign_key => 'reciever_id'
  has_many :created_events, :class_name => 'Event', :foreign_key => 'event_id'
  has_many :joined_awgs, :class_name => 'Awg', :foreign_key => 'awg_id'


end
