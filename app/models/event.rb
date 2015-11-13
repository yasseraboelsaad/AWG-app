class Event < ActiveRecord::Base
	belongs_to :creator, :class_name => 'user', :foreign_key => 'user_id'
	before_create :end_date_cant_be_before_start_date

	def end_date_cant_be_before_start_date
    if time > endtime
      errors.add(:endtime, "End time cant be before the start time")
    end
  end

end
