class CreateTasks < ActiveRecord::Migration
  def change
    create_table :tasks do |t|
      t.string :title
      t.string :description
      t.integer :assigner_id
      t.integer :assignee_id
      t.foreign_key :assigner_id
      t.foreign_key :assignee_id
      t.string :status
      t.datetime :deadline
      t.timestamps null: false
    end
  end
end
