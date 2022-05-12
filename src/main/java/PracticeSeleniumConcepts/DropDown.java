package PracticeSeleniumConcepts;

public enum DropDown {

	INDEX {
		@Override
		public String toString() {
			return "index";
		}
	},

	VALUE {
		@Override
		public String toString() {
			return "Value";
		}
	},

	VISIBLETEXT {
		@Override
		public String toString() {
			return "VisibleText";
		}
	}

}
