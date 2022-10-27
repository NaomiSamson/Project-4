
public class Plot extends Object{
	private int X, Y, Width, Depth; 
	
	public Plot() {
		this.X = this.Y = 0;
		this.Depth = this.Width = 1;
	}
	
	public Plot(int x, int y, int width, int depth) {
		this.X = x;
		this.Y = y;
		this.Width = width;
		this.Depth = depth;
	}
	
	public Plot(Plot otherPlot) {
		this.X = otherPlot.X;
		this.Y = otherPlot.Y;
		this.Width = otherPlot.Width;
		this.Depth = otherPlot.Depth;
	}
	
	public void setX(int x) {
		this.X = x;
	}
	
	public void setY(int y) {
		this.Y = y;
	}
	
	public void setWidth(int width) {
		this.Width = width;
	}
	
	public void setDepth(int depth) {
		this.Depth = depth;
	}
	
	public int getX() {
		return this.X;
	}
	
	public int getY() {
		return this.Y;
	}
	
	public int getWidth() {
		return this.Width;
	}
	
	public int getDepth() {
		return this.Depth;
	}
	
	@Override
	public String toString() {
		return this.X + "," + this.Y + "," + this.Width + "," + this.Depth;
	}
	
	public boolean overlaps(Plot plot) {
		int px1 = plot.X;
		int px2 = plot.X + plot.Width;
		
		int py1 = plot.Y;
		int py2 = plot.Y + plot.Depth;
		
		if ((px1 >= this.X && px1 <= this.X + this.Width) 
				|| (px2 >= this.X && px2 <= this.X + this.Width)) {
			if ((py1 >= this.Y && py1 <= this.Y + this.Depth) 
				|| (py2 >= this.Y && py2 <= this.Y + this.Depth)) {
				return true;
			}
			else if ((py1 <= this.Y && py1 >= this.Y + this.Depth) 
					|| (py2 <= this.Y && py2 >= this.Y + this.Depth)) {
				return true;
			}
			
			return false;
		}
		else if ((px1 <= this.X && px1 >= this.X + this.Width) 
				|| (px2 <= this.X && px2 >= this.X + this.Width)) {
			if ((py1 >= this.Y && py1 <= this.Y + this.Depth) 
				|| (py2 >= this.Y && py2 <= this.Y + this.Depth)) {
				return true;
			}
			else if ((py1 <= this.Y && py1 >= this.Y + this.Depth) 
					|| (py2 <= this.Y && py2 >= this.Y + this.Depth)) {
				return true;
			}
			
			return false;
		}
		
		return false;
	}
	
	public boolean encompasses(Plot plot) {
		int px1 = plot.X;
		int px2 = plot.X + plot.Width;
		
		int py1 = plot.Y;
		int py2 = plot.Y + plot.Depth;
		
		if ((px1 >= this.X && px1 <= this.X + this.Width) 
			&& (px2 >= this.X && px2 <= this.X + this.Width)
			&& (py1 >= this.Y && py1 <= this.Y + this.Depth)
			&& (py2 >= this.Y && py2 <= this.Y + this.Depth))
		{
			return true;
		}
		
		return false;
	}
}
