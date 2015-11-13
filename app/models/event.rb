class Event < ActiveRecord::Base
	belongs_to :creator, :class_name => 'User', :foreign_key => 'user_id' 
end
