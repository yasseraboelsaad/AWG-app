class Task < ActiveRecord::Base
	belongs_to :assigner, :class_name => 'user', :foreign_key => 'assigner_id'
	belongs_to :assignee, :class_name => 'user', :foreign_key => 'assignee_id'
end
