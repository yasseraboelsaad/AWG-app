class Event < ActiveRecord::Base
	belongs_to :creator, :class_name => 'user', :foreign_key => 'user_id'
end
