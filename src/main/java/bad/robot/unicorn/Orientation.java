package bad.robot.unicorn;

import static bad.robot.unicorn.Coordinate.coordinate;

/**
 * When looking at the HAT with the 'UNICORN HAT' label readable without turning your head.
 */
public enum Orientation {

	UP {
		@Override
		public Coordinate getCoordinateFrom(int x, int y) {
			return coordinate(x, y);
		}
	},
	RIGHT {
		@Override
		public Coordinate getCoordinateFrom(int x, int y) {
			return coordinate(y, 7 - x);
		}
	},
	DOWN {
		@Override
		public Coordinate getCoordinateFrom(int x, int y) {
			return coordinate(7 - x, 7 - y);
		}
	},
	LEFT {
		@Override
		public Coordinate getCoordinateFrom(int x, int y) {
			return coordinate(7 - y, x);
		}
	};

	public abstract Coordinate getCoordinateFrom(int x, int y);
}
