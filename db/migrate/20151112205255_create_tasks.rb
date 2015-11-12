class CreateTasks < ActiveRecord::Migration
  def change
    create_table :tasks do |t|
      t.string :title
      t.string :description
      t.integer :assigner
      t.integer :assignee
      t.string :status
      t.datetime :deadline

      t.timestamps null: false
    end
  end
end
