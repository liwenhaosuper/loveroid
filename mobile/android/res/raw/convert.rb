#!/usr/bin/env ruby
CUR_DIR = File.expand_path(File.dirname(__FILE__))
Dir.foreach(CUR_DIR) do |f|
  match = f.match(/(.*).png.PNG$/)
  next if match.nil?
  File.rename(f, "#{match[1]}.pgl")
end